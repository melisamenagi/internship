package com.project.catalog1.exception;

import com.project.catalog1.web.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFound(HttpServletRequest request, Exception exception) {
        BaseException baseException = (BaseException) exception;
        ErrorDto errorDto = new ErrorDto(baseException.getErrorCode(), baseException.getMessage(), HttpStatus.NOT_FOUND.value());

        return errorDto;
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(HttpServletRequest request, Exception exception) {
        return new ErrorDto("Internal.server.error", "An error occured", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
