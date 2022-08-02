package com.glady.exception;

import java.time.LocalDateTime;

public record ExceptionModel(String message, LocalDateTime timestamp, String description) {
}
