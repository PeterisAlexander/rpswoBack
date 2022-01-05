package com.game.rpswoBack.entities;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user", schema="user", catalog="")
public class UserEntity {
	private int id;
	private String username;
	private String email;
	private String password;
	private String role;
	private Integer totalcards;
	private Integer rocks;
	private Integer papers;
	private Integer scissors;
	private Integer coins;
	private Integer stars;
	private Integer victory;
	private Integer defeat;
	private Integer gamesplayed;
	private String image;
	
	public UserEntity() {
		
	}

	public UserEntity(int id, String username, String email, String password, String role, Integer totalcards, Integer rocks, Integer papers, Integer scissors,
			Integer coins, Integer stars, Integer victory, Integer defeat, Integer gamesplayed, String image) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.totalcards = totalcards;
		this.rocks = rocks;
		this.papers = papers;
		this.scissors = scissors;
		this.coins = coins;
		this.stars = stars;
		this.victory = victory;
		this.defeat = defeat;
		this.gamesplayed = gamesplayed;
		this.image = image;
	}
	
	@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Basic
    @Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Basic
    @Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Basic
    @Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Basic
    @Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Basic
    @Column(name = "totalcards")
	public Integer getTotalcards() {
		return totalcards;
	}

	public void setTotalcards(Integer totalcards) {
		this.totalcards = totalcards;
	}
	
	@Basic
    @Column(name = "rocks")
	public Integer getRocks() {
		return rocks;
	}

	public void setRocks(Integer rocks) {
		this.rocks = rocks;
	}
	
	@Basic
    @Column(name = "papers")
	public Integer getPapers() {
		return papers;
	}

	public void setPapers(Integer papers) {
		this.papers = papers;
	}
	
	@Basic
    @Column(name = "scissors")
	public Integer getScissors() {
		return scissors;
	}

	public void setScissors(Integer scissors) {
		this.scissors = scissors;
	}
	
	@Basic
    @Column(name = "coins")
	public Integer getCoins() {
		return coins;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}
	
	@Basic
    @Column(name = "stars")
	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	@Basic
    @Column(name = "victory", nullable = true)
	public Integer getVictory() {
		return victory;
	}

	public void setVictory(Integer victory) {
		this.victory = victory;
	}
	
	@Basic
    @Column(name = "defeat", nullable = true)
	public Integer getDefeat() {
		return defeat;
	}

	public void setDefeat(Integer defeat) {
		this.defeat = defeat;
	}
	
	@Basic
    @Column(name = "gamesplayed", nullable = true)
	public Integer getGamesplayed() {
		return gamesplayed;
	}

	public void setGamesplayed(Integer gamesplayed) {
		this.gamesplayed = gamesplayed;
	}
	
	@Basic
    @Column(name = "image", nullable = true)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(totalcards, that.totalcards) && Objects.equals(rocks, that.rocks) && Objects.equals(papers, that.papers) && Objects.equals(scissors, that.scissors) && Objects.equals(coins, that.coins) && Objects.equals(stars, that.stars) && Objects.equals(victory, that.victory) && Objects.equals(defeat, that.defeat) && Objects.equals(gamesplayed, that.gamesplayed) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, role, totalcards, rocks, papers, scissors, coins, stars, victory, defeat, gamesplayed, image);
    }
}
