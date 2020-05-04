package br.com.jokenpo.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "error")
public class ErrorResponse 
{
    // General error message about nature of error
    private String message;
 
    // Specific errors in API request processing
    private List<String> details;
 
}
