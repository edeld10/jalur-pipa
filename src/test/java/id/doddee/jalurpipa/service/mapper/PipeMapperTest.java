package id.doddee.jalurpipa.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PipeMapperTest {
    private PipeMapper pipeMapper;

    @BeforeEach
    public void setUp() {
        pipeMapper = new PipeMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(pipeMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(pipeMapper.fromId(null)).isNull();
    }
}
