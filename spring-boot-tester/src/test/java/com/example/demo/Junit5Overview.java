package com.example.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Test classes must not be abstract and must have a single constructor.")
//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class Junit5Overview {

    static final Logger logger = LoggerFactory.getLogger(Junit5Overview.class);

    /**
     * Lifecycle Methods
     *
     * {@link BeforeAll}
     * {@link AfterAll}
     * {@link BeforeEach}
     * {@link AfterEach}
     */
    @BeforeAll
    static void init() {
        logger.info("BeforeAll, AfterAll must be static methods.");
    }

    /**
     * Test Methods
     * {@link Test}
     * {@link RepeatedTest}
     * {@link ParameterizedTest}
     * {@link TestFactory}
     * {@link TestTemplate}
     */
    @Test
    @DisplayName("Display custom name for Test")
    void TEST_001() {
        // Assumptions
        Assumptions.assumeTrue("abc".contains("Z"));

        // Assertions
        Assertions.fail("a failing test");
    }

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @EnabledOnOs({OS.MAC})
    void onlyOnMacOs() {
        // Disabled on operating system: Windows 10
    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_11)
    void fromJava8To11() {
        logger.info("Enable Java 1.8 to 11.");
    }

    /**
     * Only non-static nested classes (i.e. inner classes) can serve as @Nested test classes.
     */
    @Nested
    @Disabled("Disabled until bug #99 has been fixed")
    class DisabledClassDemo {

        @Test
        void testWillBeSkipped() {
            logger.info("testWillBeSkipped");
        }

    }

}
