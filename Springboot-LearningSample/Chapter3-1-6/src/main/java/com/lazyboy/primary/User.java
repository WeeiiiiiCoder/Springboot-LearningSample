package com.lazyboy.primary;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "User")
public class User {
    private String name;
    private Integer age;
}
