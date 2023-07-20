package com.backSpringBatch.postgres.models.Acosux;

public class AcosuxBodyInfoSys {
	
	private String empresa;
    private String usuarioCompleto="SOPORTE OWS";
    private String usuario ="SOPORTE";
    private String usuarioNick="soporte";
    private String mac="";
    private String empresaRuc=null;
    private String ambiente="WEB";
    private String imagen="";
    private String email="kmarin@procamaronex.com\"";
    private String telefono=null;
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getUsuarioCompleto() {
		return usuarioCompleto;
	}
	public void setUsuarioCompleto(String usuarioCompleto) {
		this.usuarioCompleto = usuarioCompleto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getEmpresaRuc() {
		return empresaRuc;
	}
	public void setEmpresaRuc(String empresaRuc) {
		this.empresaRuc = empresaRuc;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public AcosuxBodyInfoSys(String empresa, String usuarioCompleto, String usuario, String usuarioNick, String mac,
			String empresaRuc, String ambiente, String imagen, String email, String telefono) {
		super();
		this.empresa = empresa;
		this.usuarioCompleto = usuarioCompleto;
		this.usuario = usuario;
		this.usuarioNick = usuarioNick;
		this.mac = mac;
		this.empresaRuc = empresaRuc;
		this.ambiente = ambiente;
		this.imagen = imagen;
		this.email = email;
		this.telefono = telefono;
	}
	public String getUsuarioNick() {
		return usuarioNick;
	}
	public void setUsuarioNick(String usuarioNick) {
		this.usuarioNick = usuarioNick;
	}


	public AcosuxBodyInfoSys() {
	}
}
