package com.backSpringBatch.postgres.models.Acosux;

import java.io.Serializable;
import java.util.Date;


public class SisUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private String usrCodigo;
    private String usrNick;
    private String usrNombre;
    private String usrApellido;
    private String usrPassword;

    private Date usrCaduca;
    private boolean usrActivo;
    private boolean usrCambiarContrasenia;
    private String usrEmail;
    private String usrPasswordEmail;
    private String usrIP;
    private String usrCodigoInserta;

    private Date usrFechaInsertaUsuario;
    private String usrTelefono;

    public SisUsuario() {
    }

    public SisUsuario(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public SisUsuario(String usrCodigo, String usrNick, String usrNombre, String usrApellido, String usrPassword,
            Date usrCaduca, boolean usrActivo, boolean usrCambiarContrasenia, String usrEmail, String usrPasswordEmail,
            String usrIP, String usrCodigoInserta, Date usrFechaInsertaUsuario, String usrTelefono) {
        this.usrCodigo = usrCodigo;
        this.usrNick = usrNick;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
        this.usrPassword = usrPassword;
        this.usrCaduca = usrCaduca;
        this.usrActivo = usrActivo;
        this.usrCambiarContrasenia = usrCambiarContrasenia;
        this.usrEmail = usrEmail;
        this.usrPasswordEmail = usrPasswordEmail;
        this.usrIP = usrIP;
        this.usrCodigoInserta = usrCodigoInserta;
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
        this.usrTelefono = usrTelefono;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrNick() {
        return usrNick;
    }

    public void setUsrNick(String usrNick) {
        this.usrNick = usrNick;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Date getUsrCaduca() {
        return usrCaduca;
    }

    public void setUsrCaduca(Date usrCaduca) {
        this.usrCaduca = usrCaduca;
    }

    public boolean getUsrActivo() {
        return usrActivo;
    }

    public void setUsrActivo(boolean usrActivo) {
        this.usrActivo = usrActivo;
    }

    public boolean getUsrCambiarContrasenia() {
        return usrCambiarContrasenia;
    }

    public void setUsrCambiarContrasenia(boolean usrCambiarContrasenia) {
        this.usrCambiarContrasenia = usrCambiarContrasenia;
    }

    public String getUsrCodigoInserta() {
        return usrCodigoInserta;
    }

    public void setUsrCodigoInserta(String usrCodigoInserta) {
        this.usrCodigoInserta = usrCodigoInserta;
    }

    public Date getUsrFechaInsertaUsuario() {
        return usrFechaInsertaUsuario;
    }

    public void setUsrFechaInsertaUsuario(Date usrFechaInsertaUsuario) {
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrPasswordEmail(String usrPasswordEmail) {
        this.usrPasswordEmail = usrPasswordEmail;
    }

    public String getUsrPasswordEmail() {
        return usrPasswordEmail;
    }

    public String getUsrIP() {
        return usrIP;
    }

    public void setUsrIP(String usrIP) {
        this.usrIP = usrIP;
    }

    public String getUsrTelefono() {
        return usrTelefono;
    }

    public void setUsrTelefono(String usrTelefono) {
        this.usrTelefono = usrTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrCodigo != null ? usrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SisUsuario)) {
            return false;
        }
        SisUsuario other = (SisUsuario) object;
        if ((this.usrCodigo == null && other.usrCodigo != null)
                || (this.usrCodigo != null && !this.usrCodigo.equals(other.usrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisUsuario[ usrCodigo=" + usrCodigo + " ]";
    }
}
