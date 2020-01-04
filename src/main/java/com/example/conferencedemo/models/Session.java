package com.example.conferencedemo.models;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;


import java.util.List;

@Entity(name = "sessions")
@Table(name = "sessions")
public class Session{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long session_id;
    
    private String session_name;
    private String session_description;
    private Integer session_length;
    
    @JsonIgnoreProperties("sessionList")
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "session_speakers",
            joinColumns = { @JoinColumn(name = "session_id") },
            inverseJoinColumns = { @JoinColumn(name = "speaker_id") })
    private List<Speaker> speakerList;
    
    public Session(){
        
    }
    
    public Long getSession_id(){
        
        return session_id;
    }
    
    public void setSession_id(Long session_id){
        
        this.session_id = session_id;
    }
    
    public String getSession_name(){
        
        return session_name;
    }
    
    public void setSession_name(String session_name){
        
        this.session_name = session_name;
    }
    
     public String getSession_description(){
        
        return session_description;
    }
    
    public void setSession_description(String session_description){
        
        this.session_description = session_description;
    }
    
    public Integer getSession_length(){
        
        return session_length;
    }
    
    public void setSession_length(Integer session_length){
        
        this.session_length = session_length;
    }
    
    public List getSpeakerList(){
        
         return speakerList;
    }
    
    public void setSpeakerList(List speakerList){
        
        this.speakerList = speakerList;
    }
    
}