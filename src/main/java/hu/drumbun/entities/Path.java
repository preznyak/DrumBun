package hu.drumbun.entities;

import javax.persistence.*;

@Entity(name = "Path")
public class Path {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name = "start")
    private String start;

    @Column(name = "destination")
    private String destination;

    @Column(name = "enroute")
    private String enroute;

    public Path(String start, String destination, String enroute) {
        this.start = start;
        this.destination = destination;
        this.enroute = enroute;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEnroute() {
        return enroute;
    }

    public void setEnroute(String enroute) {
        this.enroute = enroute;
    }

    @Override
    public String toString() {
        return "Path{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", destination='" + destination + '\'' +
                ", enroute='" + enroute + '\'' +
                '}';
    }
}
