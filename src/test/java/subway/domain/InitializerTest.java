package subway.domain;

import org.junit.jupiter.api.Test;
import repository.LineRepository;
import repository.SectionRepository;
import repository.StationRepository;
import repository.SubwayRepository;

import static org.junit.jupiter.api.Assertions.*;

class InitializerTest {
    @Test
    public void testInitializer_지하철역() {
        Initializer initializer = new Initializer();
        initializer.init();
        StationRepository.stations().stream().map(station -> station.getName()).forEach(System.out::println);
    }

    @Test
    public void testInitializer_지하철노선() {
        Initializer initializer = new Initializer();
        initializer.init();
        LineRepository.lines().stream().map(line -> line.getName()).forEach(System.out::println);
    }

    @Test
    public void testInitializer_구간() {
        Initializer initializer = new Initializer();
        initializer.init();
        for (Section section : SectionRepository.sections()) {
            section.stations().stream().map(station -> station.getName() + " ").forEach(System.out::println);
            System.out.println("거리 " + section.getDistance());
            System.out.println("시간 " + section.getTime());
        }
    }

    @Test
    public void testInitializer_지하철전체() {
        Initializer initializer = new Initializer();
        initializer.init();
        System.out.println(SubwayRepository.graphByTime());
        System.out.println(SubwayRepository.graphByDistance());
    }
}