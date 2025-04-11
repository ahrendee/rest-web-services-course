package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp, String message, String details) {
}
