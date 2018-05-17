package com.assignemnt3.server.model;

import javax.persistence.*;

@Entity
@Table(name = "friendships")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long friendshipId;

    @Column
    private Long firstUserId;

    @Column
    private Long secondUserId;

    @Column
    private String secondUserUsername;

    public Friendship() {
        this(null, null, null, null);
    }

    public Friendship(Long friendshipId, Long firstUserId, Long secondUserId, String secondUserUsername) {
        this.friendshipId = friendshipId;
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.secondUserUsername = secondUserUsername;
    }

    public Long getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Long friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Long getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(Long firstUserId) {
        this.firstUserId = firstUserId;
    }

    public Long getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(Long secondUserId) {
        this.secondUserId = secondUserId;
    }

    public String getSecondUserUsername() {
        return secondUserUsername;
    }

    public void setSecondUserUsername(String secondUserUsername) {
        this.secondUserUsername = secondUserUsername;
    }
}
