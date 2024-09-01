package edu.eci.cvds.tdd.library.user;

public class User {
    private String name;
    private String id;
    
    public User(String id, String name) {
        if (id == null || id.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El ID o el nombre no puede quedar vacío.");
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}