package com.codex.devserver.domain.log;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_log_record")
public class LogRecord {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE )
	@Column
	private long id;
	
	@ManyToOne( targetEntity=Logger.class , fetch=FetchType.LAZY)
	@JoinColumn( name="logger_id")
	private Logger logger;
	
	@Column
	private Timestamp timestamp;
	
	@Column
	private String tag;
	
	@Column
	private LogLevel level;
	
	@Column
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public LogLevel getLevel() {
		return level;
	}

	public void setLevel(LogLevel level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
