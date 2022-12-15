package repository;

import org.junit.jupiter.api.Test;
import subway.domain.Initializer;
import subway.domain.Station;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {
    @Test
    public void testStationRepository() {
        Station station1 = new Station("2호선");
        Station station2 = new Station("2호선");
        assertThat(station1.equals(station2)).isTrue();
    }
}