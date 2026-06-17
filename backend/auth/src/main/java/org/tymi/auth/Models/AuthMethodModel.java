package org.tymi.auth.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "authmethod")
public class AuthMethodModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ColumnDefault("1")
	@Column(name = "enabled", nullable = false)
	private Boolean enabled;
	@Column(name = "lastUsedAt")
	private Instant lastUsedAt;
	@Column(name = "updatedAt")
	private Instant updatedAt;
	@ColumnDefault("current_timestamp()")
	@Column(name = "createdAt", nullable = false)
	private Instant createdAt;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "userId", nullable = false)
	private UserEntryModel user;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "factorId", nullable = false)
	private AuthMethodFactor factor;
	@Column(name = "credential", nullable = false)
	private byte[] credential;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "methodId", nullable = false)
	private AuthMethodType method;
	@Column(name = "name", nullable = false, length = 72)
	private String name;

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Instant getLastUsedAt() {
		return lastUsedAt;
	}

	public void setLastUsedAt(Instant lastUsedAt) {
		this.lastUsedAt = lastUsedAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public UserEntryModel getUser() {
		return user;
	}

	public void setUser(UserEntryModel user) {
		this.user = user;
	}

	public AuthMethodFactor getFactor() {
		return factor;
	}

	public void setFactor(AuthMethodFactor factor) {
		this.factor = factor;
	}

	public byte[] getCredential() {
		return credential;
	}

	public void setCredential(byte[] credential) {
		this.credential = credential;
	}

	public AuthMethodType getMethod() {
		return method;
	}

	public void setMethod(AuthMethodType method) {
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
}
