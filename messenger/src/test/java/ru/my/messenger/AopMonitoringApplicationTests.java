package ru.my.messenger;

import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.my.messenger.infrastructure.persistents.MessageTable;

class AopMonitoringApplicationTests {

    @MockBean
    private BuildProperties buildProperties;
    @MockBean
    private MessageTable table;
    @MockBean
    private MeterFilter meterFilter;

}
