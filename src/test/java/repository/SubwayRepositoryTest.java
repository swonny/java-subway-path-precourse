package repository;

import org.junit.jupiter.api.Test;
import subway.domain.Initializer;
import subway.domain.Section;
import subway.domain.Station;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SubwayRepositoryTest {
    @Test
    public void testSubwayRepository() {
        Initializer initializer = new Initializer();
        initializer.init();
        SubwayRepository.getShortestPathByDistance("강남역", "교대역")
                .stream().map(station -> station.getName())
                .forEach(System.out::println);
    }

    @Test
    public void testSubwayRepository_여러개역() {
        Initializer initializer = new Initializer();
        initializer.init();
        SubwayRepository.getShortestPathByDistance("교대역", "역삼역")
                .stream().map(station -> station.getName())
                .forEach(System.out::println);
    }

    @Test
    public void testSubwayRepository_다른노선과() {
        Initializer initializer = new Initializer();
        initializer.init();
        SubwayRepository.getShortestPathByDistance("교대역", "양재역")
                .stream().map(station -> station.getName())
                .forEach(System.out::println);
    }

    @Test
    public void testSubwayRepository_시간기준() {
        Initializer initializer = new Initializer();
        initializer.init();
        SubwayRepository.getShortestPathByTime("교대역", "양재역")
                .stream().map(station -> station.getName())
                .forEach(System.out::println);
    }

    @Test
    public void testSubwayRepository_출발도착같을경우() {
        Initializer initializer = new Initializer();
        initializer.init();
        assertThatThrownBy(() -> SubwayRepository.getShortestPathByTime("교대역", "교대")
                .stream().map(station -> station.getName())
                .forEach(System.out::println))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testSubwayRepository_연결안된경우() {
        Initializer initializer = new Initializer();
        initializer.init();
        Station station1 = new Station("역곡");
        Station station2 = new Station("송내");
        Section section = new Section(List.of(station1, station2), 1, 1);
        SubwayRepository.initializeSection(section);
        assertThatThrownBy(() -> SubwayRepository.getShortestPathByTime("강남역", "역곡"))
                .hasMessageContaining("연결되어 있지 않은 경로입니다.");
    }
}