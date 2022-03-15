package com.lms.library.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A book with that ID number cannot be found")
public class BookNotFoundException extends EntityNotFoundException {

}
