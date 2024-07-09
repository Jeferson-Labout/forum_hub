package com.laboutapi.aluraforumapi.domain.enums;

public enum Perfil {
	ADMINISTRADOR(0, "ROLE_ADMIN"), MODERADOR(1, "ROLE_MODERADOR"), USUARIO(2, "ROLE_USUARIO"), VISITANTE(3, "ROLE_VISITANTE");
	
	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		
	}
	
	public Integer getCodigo(){
		return codigo;
	}
	
	public String getDescricao(){
		return descricao;	
		
	}
	
	
	public static Perfil toEnum(Integer cod) {
		
		if(cod==null) {
			return null;
		}
		
		for(Perfil x: Perfil.values()) {
			
			if(cod.equals(x.getCodigo())) {
				
				return x;
			}
			
		}
		
		throw new IllegalArgumentException("Perfil invalido");
	}
}
