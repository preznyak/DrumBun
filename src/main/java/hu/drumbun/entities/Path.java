package hu.drumbun.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <h1>Path Entity class</h1>
 * A class that represents a path in the db
 *
 * @author Preznyak Laszlo
 * @version 1.0
 */
@Entity
@Table(name = "Path")
public class Path implements Serializable {

    /**
     * id of the path
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    /**
     * start place of the path
     */
    @Column(name = "start")
    private String start;

    /**
     * destination of the path
     */
    @Column(name = "destination")
    private String destination;

    /**
     * enroute
     */
    @Column(name = "enroute")
    private String enroute;

    /**
     * Constructor
     * @param start start place
     * @param destination destination
     * @param enroute enroute
     */
    public Path(String start, String destination, String enroute) {
        this.start = start;
        this.destination = destination;
        this.enroute = enroute;
    }

    /**
     * Getter method for id
     * @return id of the path
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for id
     * @param id id of the path
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for start place of path
     * @return start place
     */
    public String getStart() {
        return start;
    }

    /**
     * Setter method for start place
     * @param start start place
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Getter method for destination
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setter method for destination
     * @param destination destination of the path
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Getter method for enroute
     * @return enroute
     */
    public String getEnroute() {
        return enroute;
    }

    /**
     * Setter method for enroute
     * @param enroute Places where the path goes by
     */
    public void setEnroute(String enroute) {
        this.enroute = enroute;
    }

    /**
     * toString method of the Path class
     * @return string format of a Path object
     */
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
