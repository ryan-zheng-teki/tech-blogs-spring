package com.qiusuo.techblogs.gatekeeper.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GithubGateKeeperTest {

    @Autowired
    GithubGateKeeperController gatekeeper;

    @Test
    public void contexLoads() throws Exception {
        assertThat(gatekeeper).isNotNull();
    }
}
