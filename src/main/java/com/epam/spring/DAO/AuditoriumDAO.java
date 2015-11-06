package com.epam.spring.DAO;

import com.epam.spring.entity.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria_Tomilova on 31-Oct-15.
 */
public class AuditoriumDAO {

//    private Auditorium auditorium1;
//    private Auditorium auditorium2;

    private List<Auditorium> auditoriums;

    public AuditoriumDAO(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
//        this.auditorium1 = auditorium1;
//        this.auditorium2 = auditorium2;
//        auditoriums.add(auditorium1);
//        auditoriums.add(auditorium2);
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    //    public Auditorium getAuditorium1() {
//        return auditorium1;
//    }
//
//    public Auditorium getAuditorium2() {
//        return auditorium2;
//    }
//
//    public void setAuditorium1(Auditorium auditorium1) {
//        this.auditorium1 = auditorium1;
//    }
//
//    public void setAuditorium2(Auditorium auditorium2) {
//        this.auditorium2 = auditorium2;
//    }

    public void add(Auditorium auditorium) {
        auditoriums.add(auditorium);
    }

    public void remove(Auditorium auditorium) {
        auditoriums.remove(auditorium);
    }

    public void update(Auditorium auditorium) {
        auditoriums.get(auditorium.getId() - 1).setName(auditorium.getName());
        auditoriums.get(auditorium.getId() - 1).setNumbersOfSeats(auditorium.getNumbersOfSeats());
        auditoriums.get(auditorium.getId() - 1).setVipSeats(auditorium.getVipSeats());
        auditoriums.get(auditorium.getId() - 1).setCalendar(auditorium.getCalendar());
    }

    public List<Auditorium> getAll() {
        return auditoriums;
    }

    public Auditorium getAuditoriumByName(String name) {
      for (Auditorium auditorium : auditoriums) {
          if (auditorium.getName().equals(name)) {
              return auditorium;
          }
      }
        return null;
    }
}
