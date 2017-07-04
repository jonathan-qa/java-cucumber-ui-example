package com.e2e.page;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jonathans on 03/07/17.
 */

@Component
@Getter

public class NinjaPageHomePrivate extends CommonsPage {

    @Value("${ninja.private.url}")
    private String privateNinjaUrl;

    @Override
    protected String getResource() {
        return "/";
    }
}
