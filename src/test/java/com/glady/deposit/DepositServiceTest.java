package com.glady.deposit;

import com.glady.constant.Constant;
import com.glady.db.entity.Compagny;
import com.glady.db.repository.DepositRepository;
import com.glady.db.repository.UserRepository;
import com.glady.exception.NotFound;
import com.glady.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DepositServiceTest {

    @Mock
    private DepositRepository depositRepository;
    @Mock
    private UserRepository userRepository;

    private DepositService depositService;

    private Deposit deposit;

    @BeforeEach
    void setUp(){
        depositService = new DepositService(depositRepository, userRepository);
        deposit = new Deposit(
                100D,
                null,
                null,
                new User(
                        1L,
                        "Jean",
                        "Contesse",
                        LocalDate.of(1990, 2, 1),
                        "TEST",
                        "TEST",
                        "TEST"
                )
        );
    }

    @Test
    void shouldThrownExceptionWhenUserNotFound(){
        Long depositUserId = 9999L;
        lenient().when(userRepository.findById(depositUserId)).thenReturn(Optional.empty());
        assertThatThrownBy(
                () -> depositService.addGift(deposit)
        ).isExactlyInstanceOf(NotFound.class).hasMessageContaining("No user with id");
    }

    @Test
    void shouldAddGift(){
        com.glady.db.entity.User user = mockUser();
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(Constant.GIFT_DAYS_LIFESPAN);
        com.glady.db.entity.Deposit userDeposit = new com.glady.db.entity.Deposit(
                deposit.amount(), Type.GIFT.getLibelle(), startDate, endDate, user
        );
        depositRepository.save(userDeposit);
        ArgumentCaptor<com.glady.db.entity.Deposit> depositArgumentCaptor = ArgumentCaptor.forClass(com.glady.db.entity.Deposit.class);
        verify(depositRepository).save(depositArgumentCaptor.capture());
        com.glady.db.entity.Deposit depositArgumentCaptorValue = depositArgumentCaptor.getValue();
        assertThat(depositArgumentCaptorValue).isEqualTo(userDeposit);
    }

    @AfterEach
    void afterEach(){
        depositService = null;
    }

    private com.glady.db.entity.User mockUser(){
        Compagny compagny = new Compagny(
                "Glady",
                "GRXXKZKIKZ",
                "TEST",
                1500D
        );
        compagny.setId(1L);
        com.glady.db.entity.User user = new com.glady.db.entity.User(
                "userTest",
                "userTest",
                LocalDate.of(1999, 3, 24),
                "userTest",
                "userTest",
                compagny
        ) ;
        user.setId(1L);
        return user;
    }
}