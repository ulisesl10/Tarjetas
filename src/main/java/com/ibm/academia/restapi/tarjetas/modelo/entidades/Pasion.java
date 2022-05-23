package com.ibm.academia.restapi.tarjetas.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.restapi.tarjetas.enumeradores.TipoPasion;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "pasiones")
public class Pasion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3748794144711940460L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "No puede ser nulo")
	@Column(name = "tipo_passion")
	@Enumerated(EnumType.STRING)
	private TipoPasion tipoPasion;

	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede ser vacío")
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;

	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "cliente_pasion", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "pasion_id"))
	@JsonIgnoreProperties({"pasiones"})
	private Set<Cliente> clientes;

	

	public Pasion(Long id, TipoPasion tipoPasion, String usuarioCreacion) {
		this.id = id;
		this.tipoPasion = tipoPasion;
		this.usuarioCreacion = usuarioCreacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pasion [id=");
		builder.append(id);
		builder.append(", tipoPasion=");
		builder.append(tipoPasion);
		builder.append(", usuarioCreacion=");
		builder.append(usuarioCreacion);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoPasion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasion other = (Pasion) obj;
		return Objects.equals(id, other.id) && tipoPasion == other.tipoPasion;
	}

	@PrePersist
	private void antesPersistir() {
		this.fechaCreacion = new Date();
	}

	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date();
	}

}
