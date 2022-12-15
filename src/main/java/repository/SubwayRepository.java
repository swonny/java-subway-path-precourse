package repository;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Section;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubwayRepository {
    // TODO : Enum으로 해도 될듯 & 변수명 대신 EnumMap으로 저장
    private static WeightedMultigraph<String, DefaultWeightedEdge> graphWithTime = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> graphWithDistance = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void initializeTimeSection(Section section) {
        List<Station> stations = section.stations();
        stations.stream().forEach(station -> graphWithTime.addVertex(station.getName())); // Vertex 등록
        graphWithTime.setEdgeWeight(graphWithTime.addEdge(stations.get(0).getName(), stations.get(1).getName()), section.getTime());
    }

    public static void initializeSection(Section section) {
        initializeTimeSection(section);
        initializeDistanceSection(section);
    }

    private static void initializeDistanceSection(Section section) {
        List<Station> stations = section.stations();
        stations.stream().forEach(station -> graphWithDistance.addVertex(station.getName())); // Vertex 등록
        graphWithDistance.setEdgeWeight(graphWithDistance.addEdge(stations.get(0).getName(), stations.get(1).getName()), section.getDistance());
    }

    public static Set<String> graphByTime() {
        return graphWithTime.vertexSet();
    }

    public static Set<String> graphByDistance() {
        return graphWithDistance.vertexSet();
    }

    public static List<Station> getShortestPathByDistance(String startStation, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphWithDistance);
        List<String> shortestPathName = dijkstraShortestPath.getPath(startStation, destination).getVertexList();
        return shortestPathName.stream().map(stationName -> StationRepository.getStationByName(stationName))
                .collect(Collectors.toList());
    }

    public static List<Station> getShortestPathByTime(String startStation, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphWithTime);
        List<String> shortestPathName = dijkstraShortestPath.getPath(startStation, destination).getVertexList();
        return shortestPathName.stream().map(stationName -> StationRepository.getStationByName(stationName))
                .collect(Collectors.toList());
    }
}
