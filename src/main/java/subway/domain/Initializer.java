package subway.domain;

import repository.LineRepository;
import repository.SectionRepository;
import repository.StationRepository;
import repository.SubwayRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Initializer {

    public void init() {
        initializeStations();
        initializeLines();
        initializeSections();
        initializeSectionInformation();
    }

    private void initializeSectionInformation() {
        initializeLineNumber2();
        initializeLinenumber3();
        initializeSinbundang();
    }

    private void initializeSinbundang() {
        Line line = LineRepository.getLineByName("신분당선");
        List<Station> stations = line.stations();
        Section section1 = new Section(List.of(stations.get(0), stations.get(1)), 2, 8); // 강남역 - ( 2km / 8분 ) - 양재역
        Section section2 = new Section(List.of(stations.get(1), stations.get(2)), 10, 3); // 양재역 - ( 10km / 3분 ) - 양재시민의숲역
        SectionRepository.initializeSection(Arrays.asList(section1, section2));
        initializeSubwayRepository(List.of(section1, section2));
    }

    private void initializeLinenumber3() {
        Line line = LineRepository.getLineByName("3호선");
        List<Station> stations = line.stations();
        Section section1 = new Section(List.of(stations.get(0), stations.get(1)), 3, 2); // 교대역 - ( 3km / 2분 ) - 남부터미널역
        Section section2 = new Section(List.of(stations.get(1), stations.get(2)), 6, 5); // 남부터미널역 - ( 6km / 5분 ) - 양재역
        Section section3 = new Section(List.of(stations.get(2), stations.get(3)), 1, 1); // 양재역 - ( 1km / 1분 ) - 매봉역
        SectionRepository.initializeSection(Arrays.asList(section1, section2, section3));
        initializeSubwayRepository(List.of(section1, section2, section3));
    }

    private void initializeLineNumber2() {
        Line line = LineRepository.getLineByName("2호선");
        List<Station> stations = line.stations();
        Section section1 = new Section(List.of(stations.get(0), stations.get(1)), 2, 3); // 교대역 - ( 2km / 3분 ) - 강남역
        Section section2 = new Section(List.of(stations.get(1), stations.get(2)), 2, 3); // 강남역 - ( 2km / 3분 ) - 역삼역
        SectionRepository.initializeSection(Arrays.asList(section1, section2));
        initializeSubwayRepository(List.of(section1, section2));
    }

    private void initializeSubwayRepository(List<Section> sections) {
        for (Section section : sections) {
            // TODO : station 이름 두 개, 가중치 두 개 넘겨주는건?
            SubwayRepository.initializeSection(section);
        }
    }

    private void initializeSections() {
        String lineOfSection1 = "2호선";
        List<Station> stationsOfSection1 = Arrays.asList("교대역", "강남역", "역삼역").stream()
                .map(station -> StationRepository.getStationByName(station)).collect(Collectors.toList());
        String lineOfSection2 = "3호선";
        List<Station> stationsOfSection2 = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역").stream()
                .map(station -> StationRepository.getStationByName(station)).collect(Collectors.toList());
        String lineOfSection3 = "신분당선";
        List<Station> stationsOfSection3 = Arrays.asList("강남역", "양재역", "양재시민의숲역").stream()
                .map(station -> StationRepository.getStationByName(station)).collect(Collectors.toList());
        LineRepository.getLineByName(lineOfSection1).initializeStations(stationsOfSection1);
        LineRepository.getLineByName(lineOfSection2).initializeStations(stationsOfSection2);
        LineRepository.getLineByName(lineOfSection3).initializeStations(stationsOfSection3);
    }

    private void initializeLines() {
        List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");
        lines.stream()
                .forEach(line -> LineRepository.addLine(new Line(line)));
    }

    private void initializeStations() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        stations.stream()
                .forEach(station -> StationRepository.addStation(new Station(station)));
    }
}
