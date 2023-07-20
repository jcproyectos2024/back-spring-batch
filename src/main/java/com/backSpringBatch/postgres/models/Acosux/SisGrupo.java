package com.backSpringBatch.postgres.models.Acosux;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class SisGrupo implements Serializable {

    private static final long serialVersionUID = 1L;

    protected SisGrupoPK sisGrupoPK;

    private String gruNombre;

    private Boolean gruCrear;
    private Boolean gruCrearClientes;
    private Boolean gruCrearProveedores;
    private Boolean gruCrearProductos;
    private Boolean gruCrearCuentasContables;
    private Boolean gruCrearEmpleados;
    private Boolean gruCrearCentrosProduccion;
    private Boolean gruCrearCentrosCosto;
    private Boolean gruCrearPeriodosSistema;
    private Boolean gruCrearPeriodosProduccion;
    private Boolean gruCrearRequisiones;

    private Boolean gruModificar;
    private Boolean gruModificarClientes;
    private Boolean gruModificarProveedores;
    private Boolean gruModificarProductos;
    private Boolean gruModificarCuentasContables;
    private Boolean gruModificarEmpleados;
    private Boolean gruModificarCentrosProduccion;
    private Boolean gruModificarCentrosCosto;
    private Boolean gruModificarPeriodosSistema;
    private Boolean gruModificarPeriodosProduccion;
    private Boolean gruModificarOcAprobadas;
    private Boolean gruModificarRequisiones;

    private Boolean gruEliminar;
    private Boolean gruEliminarCompras;
    private Boolean gruEliminarVentas;
    private Boolean gruEliminarConsumos;
    private Boolean gruEliminarTransferencias;
    private Boolean gruEliminarContables;
    private Boolean gruEliminarContablesTalentoHumano;
    private Boolean gruEliminarPresupuestos;
    private Boolean gruEliminarPreliquidaciones;
    private Boolean gruEliminarLiquidaciones;
    private Boolean gruEliminarProformas;
    private Boolean gruEliminarContratos;
    private Boolean gruEliminarRequisiones;

    private Boolean gruMayorizarCompras;
    private Boolean gruMayorizarVentas;
    private Boolean gruMayorizarConsumos;
    private Boolean gruMayorizarTransferencias;
    private Boolean gruMayorizarContables;
    private Boolean gruMayorizarContablesTalentoHumano;
    private Boolean gruMayorizarPresupuestos;
    private Boolean gruMayorizarPreliquidaciones;
    private Boolean gruMayorizarLiquidaciones;
    private Boolean gruMayorizarProformas;

    private Boolean gruMayorizarPagos;
    private Boolean gruMayorizarCobros;
    private Boolean gruMayorizarAnticiposClientes;
    private Boolean gruMayorizarAnticiposProveedores;

    private Boolean gruDesmayorizarCompras;
    private Boolean gruDesmayorizarVentas;
    private Boolean gruDesmayorizarConsumos;
    private Boolean gruDesmayorizarTransferencias;
    private Boolean gruDesmayorizarContables;
    private Boolean gruDesmayorizarContablesTalentoHumano;
    private Boolean gruDesmayorizarPresupuestos;
    private Boolean gruDesmayorizarPreliquidaciones;
    private Boolean gruDesmayorizarLiquidaciones;
    private Boolean gruDesmayorizarProformas;

    private Boolean gruDesmayorizarPagos;
    private Boolean gruDesmayorizarCobros;
    private Boolean gruDesmayorizarAnticiposClientes;
    private Boolean gruDesmayorizarAnticiposProveedores;

    private Boolean gruAnularCompras;
    private Boolean gruAnularVentas;
    private Boolean gruAnularConsumos;
    private Boolean gruAnularTransferencias;
    private Boolean gruAnularContables;
    private Boolean gruAnularContablesTalentoHumano;
    private Boolean gruAnularPresupuestos;
    private Boolean gruAnularPreliquidaciones;
    private Boolean gruAnularLiquidaciones;
    private Boolean gruAnularProformas;
    private Boolean gruAnularRequisiones;

    private Boolean gruAnularRetencion;

    private Boolean gruConfigurar;
    private Boolean gruImprimir;
    private Boolean gruExportar;
    private Boolean gruDashboard;
    private Boolean gruAdjuntarImagenes;

    private Boolean gruReutilizarCheque;

    private Boolean gruConsultarCompras;
    private Boolean gruConsultarVentas;
    private Boolean gruConsultarConsumos;
    private Boolean gruConsultarTransferencias;
    private Boolean gruConsultarContables;
    private Boolean gruConsultarContablesTalentoHumano;
    private Boolean gruConsultarPresupuestos;
    private Boolean gruConsultarPreliquidaciones;
    private Boolean gruConsultarLiquidaciones;
    private Boolean gruConsultarProformas;
    private Boolean gruConsultarPagos;
    private Boolean gruConsultarCobros;
    private Boolean gruConsultarAnticiposClientes;
    private Boolean gruConsultarAnticiposProveedores;
    private Boolean gruAuditarOc;

    private String usrInsertaGrupo;

    private Date usrFechaInsertaGrupo;
    private SisEmpresa empCodigo;
    private List<SisUsuarioDetalle> sisUsuarioDetalleList;

    private Boolean gruMayorizarGuiaRemision;
    private Boolean gruDesmayorizarGuiaRemision;
    private Boolean gruAnularGuiaRemision;
    private Boolean gruEliminarGuiaRemision;

    private Boolean gruAprobarRequisiciones;


    private Boolean gruPlanificacion;
    private Boolean gruCamaronera;
    private Boolean gruCalidad;
    private Boolean gruImprimirCodigoBarras;

    public SisGrupo() {
    }

    public SisGrupo(SisGrupoPK sisGrupoPK) {
        this.sisGrupoPK = sisGrupoPK;
    }

    public SisGrupo(String gruEmpresa, String gruCodigo) {
        this.sisGrupoPK = new SisGrupoPK(gruEmpresa, gruCodigo);
    }

    public SisGrupoPK getSisGrupoPK() {
        return sisGrupoPK;
    }

    public void setSisGrupoPK(SisGrupoPK sisGrupoPK) {
        this.sisGrupoPK = sisGrupoPK;
    }

    public String getGruNombre() {
        return gruNombre;
    }

    public void setGruNombre(String gruNombre) {
        this.gruNombre = gruNombre;
    }

    public Boolean getGruCrear() {
        return gruCrear;
    }

    public void setGruCrear(Boolean gruCrear) {
        this.gruCrear = gruCrear;
    }

    public Boolean getGruCrearClientes() {
        return gruCrearClientes;
    }

    public void setGruCrearClientes(Boolean gruCrearClientes) {
        this.gruCrearClientes = gruCrearClientes;
    }

    public Boolean getGruCrearProveedores() {
        return gruCrearProveedores;
    }

    public void setGruCrearProveedores(Boolean gruCrearProveedores) {
        this.gruCrearProveedores = gruCrearProveedores;
    }

    public Boolean getGruCrearProductos() {
        return gruCrearProductos;
    }

    public void setGruCrearProductos(Boolean gruCrearProductos) {
        this.gruCrearProductos = gruCrearProductos;
    }

    public Boolean getGruCrearCuentasContables() {
        return gruCrearCuentasContables;
    }

    public void setGruCrearCuentasContables(Boolean gruCrearCuentasContables) {
        this.gruCrearCuentasContables = gruCrearCuentasContables;
    }

    public Boolean getGruCrearEmpleados() {
        return gruCrearEmpleados;
    }

    public void setGruCrearEmpleados(Boolean gruCrearEmpleados) {
        this.gruCrearEmpleados = gruCrearEmpleados;
    }

    public Boolean getGruCrearCentrosProduccion() {
        return gruCrearCentrosProduccion;
    }

    public void setGruCrearCentrosProduccion(Boolean gruCrearCentrosProduccion) {
        this.gruCrearCentrosProduccion = gruCrearCentrosProduccion;
    }

    public Boolean getGruCrearCentrosCosto() {
        return gruCrearCentrosCosto;
    }

    public void setGruCrearCentrosCosto(Boolean gruCrearCentrosCosto) {
        this.gruCrearCentrosCosto = gruCrearCentrosCosto;
    }

    public Boolean getGruCrearPeriodosSistema() {
        return gruCrearPeriodosSistema;
    }

    public void setGruCrearPeriodosSistema(Boolean gruCrearPeriodosSistema) {
        this.gruCrearPeriodosSistema = gruCrearPeriodosSistema;
    }

    public Boolean getGruCrearPeriodosProduccion() {
        return gruCrearPeriodosProduccion;
    }

    public void setGruCrearPeriodosProduccion(Boolean gruCrearPeriodosProduccion) {
        this.gruCrearPeriodosProduccion = gruCrearPeriodosProduccion;
    }

    public Boolean getGruCrearRequisiones() {
        return gruCrearRequisiones;
    }

    public void setGruCrearRequisiones(Boolean gruCrearRequisiones) {
        this.gruCrearRequisiones = gruCrearRequisiones;
    }

    public Boolean getGruModificar() {
        return gruModificar;
    }

    public void setGruModificar(Boolean gruModificar) {
        this.gruModificar = gruModificar;
    }

    public Boolean getGruModificarClientes() {
        return gruModificarClientes;
    }

    public void setGruModificarClientes(Boolean gruModificarClientes) {
        this.gruModificarClientes = gruModificarClientes;
    }

    public Boolean getGruModificarProveedores() {
        return gruModificarProveedores;
    }

    public void setGruModificarProveedores(Boolean gruModificarProveedores) {
        this.gruModificarProveedores = gruModificarProveedores;
    }

    public Boolean getGruModificarProductos() {
        return gruModificarProductos;
    }

    public void setGruModificarProductos(Boolean gruModificarProductos) {
        this.gruModificarProductos = gruModificarProductos;
    }

    public Boolean getGruModificarCuentasContables() {
        return gruModificarCuentasContables;
    }

    public void setGruModificarCuentasContables(Boolean gruModificarCuentasContables) {
        this.gruModificarCuentasContables = gruModificarCuentasContables;
    }

    public Boolean getGruModificarEmpleados() {
        return gruModificarEmpleados;
    }

    public void setGruModificarEmpleados(Boolean gruModificarEmpleados) {
        this.gruModificarEmpleados = gruModificarEmpleados;
    }

    public Boolean getGruModificarCentrosProduccion() {
        return gruModificarCentrosProduccion;
    }

    public void setGruModificarCentrosProduccion(Boolean gruModificarCentrosProduccion) {
        this.gruModificarCentrosProduccion = gruModificarCentrosProduccion;
    }

    public Boolean getGruModificarCentrosCosto() {
        return gruModificarCentrosCosto;
    }

    public void setGruModificarCentrosCosto(Boolean gruModificarCentrosCosto) {
        this.gruModificarCentrosCosto = gruModificarCentrosCosto;
    }

    public Boolean getGruModificarPeriodosSistema() {
        return gruModificarPeriodosSistema;
    }

    public void setGruModificarPeriodosSistema(Boolean gruModificarPeriodosSistema) {
        this.gruModificarPeriodosSistema = gruModificarPeriodosSistema;
    }

    public Boolean getGruModificarPeriodosProduccion() {
        return gruModificarPeriodosProduccion;
    }

    public void setGruModificarPeriodosProduccion(Boolean gruModificarPeriodosProduccion) {
        this.gruModificarPeriodosProduccion = gruModificarPeriodosProduccion;
    }

    public Boolean getGruModificarOcAprobadas() {
        return gruModificarOcAprobadas;
    }

    public void setGruModificarOcAprobadas(Boolean gruModificarOcAprobadas) {
        this.gruModificarOcAprobadas = gruModificarOcAprobadas;
    }

    public Boolean getGruModificarRequisiones() {
        return gruModificarRequisiones;
    }

    public void setGruModificarRequisiones(Boolean gruModificarRequisiones) {
        this.gruModificarRequisiones = gruModificarRequisiones;
    }

    public Boolean getGruEliminar() {
        return gruEliminar;
    }

    public void setGruEliminar(Boolean gruEliminar) {
        this.gruEliminar = gruEliminar;
    }

    public Boolean getGruEliminarCompras() {
        return gruEliminarCompras;
    }

    public void setGruEliminarCompras(Boolean gruEliminarCompras) {
        this.gruEliminarCompras = gruEliminarCompras;
    }

    public Boolean getGruEliminarVentas() {
        return gruEliminarVentas;
    }

    public void setGruEliminarVentas(Boolean gruEliminarVentas) {
        this.gruEliminarVentas = gruEliminarVentas;
    }

    public Boolean getGruEliminarConsumos() {
        return gruEliminarConsumos;
    }

    public void setGruEliminarConsumos(Boolean gruEliminarConsumos) {
        this.gruEliminarConsumos = gruEliminarConsumos;
    }

    public Boolean getGruEliminarTransferencias() {
        return gruEliminarTransferencias;
    }

    public void setGruEliminarTransferencias(Boolean gruEliminarTransferencias) {
        this.gruEliminarTransferencias = gruEliminarTransferencias;
    }

    public Boolean getGruEliminarContables() {
        return gruEliminarContables;
    }

    public void setGruEliminarContables(Boolean gruEliminarContables) {
        this.gruEliminarContables = gruEliminarContables;
    }

    public Boolean getGruEliminarContablesTalentoHumano() {
        return gruEliminarContablesTalentoHumano;
    }

    public void setGruEliminarContablesTalentoHumano(Boolean gruEliminarContablesTalentoHumano) {
        this.gruEliminarContablesTalentoHumano = gruEliminarContablesTalentoHumano;
    }

    public Boolean getGruEliminarPresupuestos() {
        return gruEliminarPresupuestos;
    }

    public void setGruEliminarPresupuestos(Boolean gruEliminarPresupuestos) {
        this.gruEliminarPresupuestos = gruEliminarPresupuestos;
    }

    public Boolean getGruEliminarPreliquidaciones() {
        return gruEliminarPreliquidaciones;
    }

    public void setGruEliminarPreliquidaciones(Boolean gruEliminarPreliquidaciones) {
        this.gruEliminarPreliquidaciones = gruEliminarPreliquidaciones;
    }

    public Boolean getGruEliminarLiquidaciones() {
        return gruEliminarLiquidaciones;
    }

    public void setGruEliminarLiquidaciones(Boolean gruEliminarLiquidaciones) {
        this.gruEliminarLiquidaciones = gruEliminarLiquidaciones;
    }

    public Boolean getGruEliminarProformas() {
        return gruEliminarProformas;
    }

    public void setGruEliminarProformas(Boolean gruEliminarProformas) {
        this.gruEliminarProformas = gruEliminarProformas;
    }

    public Boolean getGruEliminarContratos() {
        return gruEliminarContratos;
    }

    public void setGruEliminarContratos(Boolean gruEliminarContratos) {
        this.gruEliminarContratos = gruEliminarContratos;
    }

    public Boolean getGruEliminarRequisiones() {
        return gruEliminarRequisiones;
    }

    public void setGruEliminarRequisiones(Boolean gruEliminarRequisiones) {
        this.gruEliminarRequisiones = gruEliminarRequisiones;
    }

    public Boolean getGruMayorizarCompras() {
        return gruMayorizarCompras;
    }

    public void setGruMayorizarCompras(Boolean gruMayorizarCompras) {
        this.gruMayorizarCompras = gruMayorizarCompras;
    }

    public Boolean getGruMayorizarVentas() {
        return gruMayorizarVentas;
    }

    public void setGruMayorizarVentas(Boolean gruMayorizarVentas) {
        this.gruMayorizarVentas = gruMayorizarVentas;
    }

    public Boolean getGruMayorizarConsumos() {
        return gruMayorizarConsumos;
    }

    public void setGruMayorizarConsumos(Boolean gruMayorizarConsumos) {
        this.gruMayorizarConsumos = gruMayorizarConsumos;
    }

    public Boolean getGruMayorizarTransferencias() {
        return gruMayorizarTransferencias;
    }

    public void setGruMayorizarTransferencias(Boolean gruMayorizarTransferencias) {
        this.gruMayorizarTransferencias = gruMayorizarTransferencias;
    }

    public Boolean getGruMayorizarContables() {
        return gruMayorizarContables;
    }

    public void setGruMayorizarContables(Boolean gruMayorizarContables) {
        this.gruMayorizarContables = gruMayorizarContables;
    }

    public Boolean getGruMayorizarContablesTalentoHumano() {
        return gruMayorizarContablesTalentoHumano;
    }

    public void setGruMayorizarContablesTalentoHumano(Boolean gruMayorizarContablesTalentoHumano) {
        this.gruMayorizarContablesTalentoHumano = gruMayorizarContablesTalentoHumano;
    }

    public Boolean getGruMayorizarPresupuestos() {
        return gruMayorizarPresupuestos;
    }

    public void setGruMayorizarPresupuestos(Boolean gruMayorizarPresupuestos) {
        this.gruMayorizarPresupuestos = gruMayorizarPresupuestos;
    }

    public Boolean getGruMayorizarPreliquidaciones() {
        return gruMayorizarPreliquidaciones;
    }

    public void setGruMayorizarPreliquidaciones(Boolean gruMayorizarPreliquidaciones) {
        this.gruMayorizarPreliquidaciones = gruMayorizarPreliquidaciones;
    }

    public Boolean getGruMayorizarLiquidaciones() {
        return gruMayorizarLiquidaciones;
    }

    public void setGruMayorizarLiquidaciones(Boolean gruMayorizarLiquidaciones) {
        this.gruMayorizarLiquidaciones = gruMayorizarLiquidaciones;
    }

    public Boolean getGruMayorizarProformas() {
        return gruMayorizarProformas;
    }

    public void setGruMayorizarProformas(Boolean gruMayorizarProformas) {
        this.gruMayorizarProformas = gruMayorizarProformas;
    }

    public Boolean getGruDesmayorizarCompras() {
        return gruDesmayorizarCompras;
    }

    public void setGruDesmayorizarCompras(Boolean gruDesmayorizarCompras) {
        this.gruDesmayorizarCompras = gruDesmayorizarCompras;
    }

    public Boolean getGruDesmayorizarVentas() {
        return gruDesmayorizarVentas;
    }

    public void setGruDesmayorizarVentas(Boolean gruDesmayorizarVentas) {
        this.gruDesmayorizarVentas = gruDesmayorizarVentas;
    }

    public Boolean getGruDesmayorizarConsumos() {
        return gruDesmayorizarConsumos;
    }

    public void setGruDesmayorizarConsumos(Boolean gruDesmayorizarConsumos) {
        this.gruDesmayorizarConsumos = gruDesmayorizarConsumos;
    }

    public Boolean getGruDesmayorizarTransferencias() {
        return gruDesmayorizarTransferencias;
    }

    public void setGruDesmayorizarTransferencias(Boolean gruDesmayorizarTransferencias) {
        this.gruDesmayorizarTransferencias = gruDesmayorizarTransferencias;
    }

    public Boolean getGruDesmayorizarContables() {
        return gruDesmayorizarContables;
    }

    public void setGruDesmayorizarContables(Boolean gruDesmayorizarContables) {
        this.gruDesmayorizarContables = gruDesmayorizarContables;
    }

    public Boolean getGruDesmayorizarContablesTalentoHumano() {
        return gruDesmayorizarContablesTalentoHumano;
    }

    public void setGruDesmayorizarContablesTalentoHumano(Boolean gruDesmayorizarContablesTalentoHumano) {
        this.gruDesmayorizarContablesTalentoHumano = gruDesmayorizarContablesTalentoHumano;
    }

    public Boolean getGruDesmayorizarPresupuestos() {
        return gruDesmayorizarPresupuestos;
    }

    public void setGruDesmayorizarPresupuestos(Boolean gruDesmayorizarPresupuestos) {
        this.gruDesmayorizarPresupuestos = gruDesmayorizarPresupuestos;
    }

    public Boolean getGruDesmayorizarPreliquidaciones() {
        return gruDesmayorizarPreliquidaciones;
    }

    public void setGruDesmayorizarPreliquidaciones(Boolean gruDesmayorizarPreliquidaciones) {
        this.gruDesmayorizarPreliquidaciones = gruDesmayorizarPreliquidaciones;
    }

    public Boolean getGruDesmayorizarLiquidaciones() {
        return gruDesmayorizarLiquidaciones;
    }

    public void setGruDesmayorizarLiquidaciones(Boolean gruDesmayorizarLiquidaciones) {
        this.gruDesmayorizarLiquidaciones = gruDesmayorizarLiquidaciones;
    }

    public Boolean getGruDesmayorizarProformas() {
        return gruDesmayorizarProformas;
    }

    public void setGruDesmayorizarProformas(Boolean gruDesmayorizarProformas) {
        this.gruDesmayorizarProformas = gruDesmayorizarProformas;
    }

    public Boolean getGruAnularCompras() {
        return gruAnularCompras;
    }

    public void setGruAnularCompras(Boolean gruAnularCompras) {
        this.gruAnularCompras = gruAnularCompras;
    }

    public Boolean getGruAnularVentas() {
        return gruAnularVentas;
    }

    public void setGruAnularVentas(Boolean gruAnularVentas) {
        this.gruAnularVentas = gruAnularVentas;
    }

    public Boolean getGruAnularConsumos() {
        return gruAnularConsumos;
    }

    public void setGruAnularConsumos(Boolean gruAnularConsumos) {
        this.gruAnularConsumos = gruAnularConsumos;
    }

    public Boolean getGruAnularTransferencias() {
        return gruAnularTransferencias;
    }

    public void setGruAnularTransferencias(Boolean gruAnularTransferencias) {
        this.gruAnularTransferencias = gruAnularTransferencias;
    }

    public Boolean getGruAnularContables() {
        return gruAnularContables;
    }

    public void setGruAnularContables(Boolean gruAnularContables) {
        this.gruAnularContables = gruAnularContables;
    }

    public Boolean getGruAnularContablesTalentoHumano() {
        return gruAnularContablesTalentoHumano;
    }

    public void setGruAnularContablesTalentoHumano(Boolean gruAnularContablesTalentoHumano) {
        this.gruAnularContablesTalentoHumano = gruAnularContablesTalentoHumano;
    }

    public Boolean getGruAnularPresupuestos() {
        return gruAnularPresupuestos;
    }

    public void setGruAnularPresupuestos(Boolean gruAnularPresupuestos) {
        this.gruAnularPresupuestos = gruAnularPresupuestos;
    }

    public Boolean getGruAnularPreliquidaciones() {
        return gruAnularPreliquidaciones;
    }

    public void setGruAnularPreliquidaciones(Boolean gruAnularPreliquidaciones) {
        this.gruAnularPreliquidaciones = gruAnularPreliquidaciones;
    }

    public Boolean getGruAnularLiquidaciones() {
        return gruAnularLiquidaciones;
    }

    public void setGruAnularLiquidaciones(Boolean gruAnularLiquidaciones) {
        this.gruAnularLiquidaciones = gruAnularLiquidaciones;
    }

    public Boolean getGruAnularProformas() {
        return gruAnularProformas;
    }

    public void setGruAnularProformas(Boolean gruAnularProformas) {
        this.gruAnularProformas = gruAnularProformas;
    }

    public Boolean getGruAnularRequisiones() {
        return gruAnularRequisiones;
    }

    public void setGruAnularRequisiones(Boolean gruAnularRequisiones) {
        this.gruAnularRequisiones = gruAnularRequisiones;
    }

    public Boolean getGruConfigurar() {
        return gruConfigurar;
    }

    public void setGruConfigurar(Boolean gruConfigurar) {
        this.gruConfigurar = gruConfigurar;
    }

    public Boolean getGruImprimir() {
        return gruImprimir;
    }

    public void setGruImprimir(Boolean gruImprimir) {
        this.gruImprimir = gruImprimir;
    }

    public Boolean getGruExportar() {
        return gruExportar;
    }

    public void setGruExportar(Boolean gruExportar) {
        this.gruExportar = gruExportar;
    }

    public String getUsrInsertaGrupo() {
        return usrInsertaGrupo;
    }

    public void setUsrInsertaGrupo(String usrInsertaGrupo) {
        this.usrInsertaGrupo = usrInsertaGrupo;
    }

    public Date getUsrFechaInsertaGrupo() {
        return usrFechaInsertaGrupo;
    }

    public void setUsrFechaInsertaGrupo(Date usrFechaInsertaGrupo) {
        this.usrFechaInsertaGrupo = usrFechaInsertaGrupo;
    }

    public SisEmpresa getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(SisEmpresa empCodigo) {
        this.empCodigo = empCodigo;
    }

    public List<SisUsuarioDetalle> getSisUsuarioDetalleList() {
        return sisUsuarioDetalleList;
    }

    public void setSisUsuarioDetalleList(List<SisUsuarioDetalle> sisUsuarioDetalleList) {
        this.sisUsuarioDetalleList = sisUsuarioDetalleList;
    }

    public Boolean getGruMayorizarPagos() {
        return gruMayorizarPagos;
    }

    public void setGruMayorizarPagos(Boolean gruMayorizarPagos) {
        this.gruMayorizarPagos = gruMayorizarPagos;
    }

    public Boolean getGruMayorizarCobros() {
        return gruMayorizarCobros;
    }

    public void setGruMayorizarCobros(Boolean gruMayorizarCobros) {
        this.gruMayorizarCobros = gruMayorizarCobros;
    }

    public Boolean getGruMayorizarAnticiposClientes() {
        return gruMayorizarAnticiposClientes;
    }

    public void setGruMayorizarAnticiposClientes(Boolean gruMayorizarAnticiposClientes) {
        this.gruMayorizarAnticiposClientes = gruMayorizarAnticiposClientes;
    }

    public Boolean getGruMayorizarAnticiposProveedores() {
        return gruMayorizarAnticiposProveedores;
    }

    public void setGruMayorizarAnticiposProveedores(Boolean gruMayorizarAnticiposProveedores) {
        this.gruMayorizarAnticiposProveedores = gruMayorizarAnticiposProveedores;
    }

    public Boolean getGruDesmayorizarPagos() {
        return gruDesmayorizarPagos;
    }

    public void setGruDesmayorizarPagos(Boolean gruDesmayorizarPagos) {
        this.gruDesmayorizarPagos = gruDesmayorizarPagos;
    }

    public Boolean getGruDesmayorizarCobros() {
        return gruDesmayorizarCobros;
    }

    public void setGruDesmayorizarCobros(Boolean gruDesmayorizarCobros) {
        this.gruDesmayorizarCobros = gruDesmayorizarCobros;
    }

    public Boolean getGruDesmayorizarAnticiposClientes() {
        return gruDesmayorizarAnticiposClientes;
    }

    public void setGruDesmayorizarAnticiposClientes(Boolean gruDesmayorizarAnticiposClientes) {
        this.gruDesmayorizarAnticiposClientes = gruDesmayorizarAnticiposClientes;
    }

    public Boolean getGruDesmayorizarAnticiposProveedores() {
        return gruDesmayorizarAnticiposProveedores;
    }

    public void setGruDesmayorizarAnticiposProveedores(Boolean gruDesmayorizarAnticiposProveedores) {
        this.gruDesmayorizarAnticiposProveedores = gruDesmayorizarAnticiposProveedores;
    }

    public Boolean getGruAnularRetencion() {
        return gruAnularRetencion;
    }

    public void setGruAnularRetencion(Boolean gruAnularRetencion) {
        this.gruAnularRetencion = gruAnularRetencion;
    }

    public Boolean getGruDashboard() {
        return gruDashboard;
    }

    public void setGruDashboard(Boolean gruDashboard) {
        this.gruDashboard = gruDashboard;
    }

    public Boolean getGruAdjuntarImagenes() {
        return gruAdjuntarImagenes;
    }

    public void setGruAdjuntarImagenes(Boolean gruAdjuntarImagenes) {
        this.gruAdjuntarImagenes = gruAdjuntarImagenes;
    }

    public Boolean getGruReutilizarCheque() {
        return gruReutilizarCheque;
    }

    public void setGruReutilizarCheque(Boolean gruReutilizarCheque) {
        this.gruReutilizarCheque = gruReutilizarCheque;
    }

    public Boolean getGruConsultarCompras() {
        return gruConsultarCompras;
    }

    public void setGruConsultarCompras(Boolean gruConsultarCompras) {
        this.gruConsultarCompras = gruConsultarCompras;
    }

    public Boolean getGruConsultarVentas() {
        return gruConsultarVentas;
    }

    public void setGruConsultarVentas(Boolean gruConsultarVentas) {
        this.gruConsultarVentas = gruConsultarVentas;
    }

    public Boolean getGruConsultarConsumos() {
        return gruConsultarConsumos;
    }

    public void setGruConsultarConsumos(Boolean gruConsultarConsumos) {
        this.gruConsultarConsumos = gruConsultarConsumos;
    }

    public Boolean getGruConsultarTransferencias() {
        return gruConsultarTransferencias;
    }

    public void setGruConsultarTransferencias(Boolean gruConsultarTransferencias) {
        this.gruConsultarTransferencias = gruConsultarTransferencias;
    }

    public Boolean getGruConsultarContables() {
        return gruConsultarContables;
    }

    public void setGruConsultarContables(Boolean gruConsultarContables) {
        this.gruConsultarContables = gruConsultarContables;
    }

    public Boolean getGruConsultarContablesTalentoHumano() {
        return gruConsultarContablesTalentoHumano;
    }

    public void setGruConsultarContablesTalentoHumano(Boolean gruConsultarContablesTalentoHumano) {
        this.gruConsultarContablesTalentoHumano = gruConsultarContablesTalentoHumano;
    }

    public Boolean getGruConsultarPresupuestos() {
        return gruConsultarPresupuestos;
    }

    public void setGruConsultarPresupuestos(Boolean gruConsultarPresupuestos) {
        this.gruConsultarPresupuestos = gruConsultarPresupuestos;
    }

    public Boolean getGruConsultarPreliquidaciones() {
        return gruConsultarPreliquidaciones;
    }

    public void setGruConsultarPreliquidaciones(Boolean gruConsultarPreliquidaciones) {
        this.gruConsultarPreliquidaciones = gruConsultarPreliquidaciones;
    }

    public Boolean getGruConsultarLiquidaciones() {
        return gruConsultarLiquidaciones;
    }

    public void setGruConsultarLiquidaciones(Boolean gruConsultarLiquidaciones) {
        this.gruConsultarLiquidaciones = gruConsultarLiquidaciones;
    }

    public Boolean getGruConsultarProformas() {
        return gruConsultarProformas;
    }

    public void setGruConsultarProformas(Boolean gruConsultarProformas) {
        this.gruConsultarProformas = gruConsultarProformas;
    }

    public Boolean getGruConsultarPagos() {
        return gruConsultarPagos;
    }

    public void setGruConsultarPagos(Boolean gruConsultarPagos) {
        this.gruConsultarPagos = gruConsultarPagos;
    }

    public Boolean getGruConsultarCobros() {
        return gruConsultarCobros;
    }

    public void setGruConsultarCobros(Boolean gruConsultarCobros) {
        this.gruConsultarCobros = gruConsultarCobros;
    }

    public Boolean getGruConsultarAnticiposClientes() {
        return gruConsultarAnticiposClientes;
    }

    public void setGruConsultarAnticiposClientes(Boolean gruConsultarAnticiposClientes) {
        this.gruConsultarAnticiposClientes = gruConsultarAnticiposClientes;
    }

    public Boolean getGruConsultarAnticiposProveedores() {
        return gruConsultarAnticiposProveedores;
    }

    public void setGruConsultarAnticiposProveedores(Boolean gruConsultarAnticiposProveedores) {
        this.gruConsultarAnticiposProveedores = gruConsultarAnticiposProveedores;
    }

    public Boolean getGruAuditarOc() {
        return gruAuditarOc;
    }

    public void setGruAuditarOc(Boolean gruAuditarOc) {
        this.gruAuditarOc = gruAuditarOc;
    }

    public Boolean getGruMayorizarGuiaRemision() {
        return gruMayorizarGuiaRemision;
    }

    public void setGruMayorizarGuiaRemision(Boolean gruMayorizarGuiaRemision) {
        this.gruMayorizarGuiaRemision = gruMayorizarGuiaRemision;
    }

    public Boolean getGruDesmayorizarGuiaRemision() {
        return gruDesmayorizarGuiaRemision;
    }

    public void setGruDesmayorizarGuiaRemision(Boolean gruDesmayorizarGuiaRemision) {
        this.gruDesmayorizarGuiaRemision = gruDesmayorizarGuiaRemision;
    }

    public Boolean getGruAnularGuiaRemision() {
        return gruAnularGuiaRemision;
    }

    public void setGruAnularGuiaRemision(Boolean gruAnularGuiaRemision) {
        this.gruAnularGuiaRemision = gruAnularGuiaRemision;
    }

    public Boolean getGruEliminarGuiaRemision() {
        return gruEliminarGuiaRemision;
    }

    public void setGruEliminarGuiaRemision(Boolean gruEliminarGuiaRemision) {
        this.gruEliminarGuiaRemision = gruEliminarGuiaRemision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisGrupoPK != null ? sisGrupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SisGrupo)) {
            return false;
        }
        SisGrupo other = (SisGrupo) object;
        if ((this.sisGrupoPK == null && other.sisGrupoPK != null)
                || (this.sisGrupoPK != null && !this.sisGrupoPK.equals(other.sisGrupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisGrupo[ sisGrupoPK=" + sisGrupoPK + " ]";
    }

    public Boolean getGruAprobarRequisiciones() {
        return gruAprobarRequisiciones;
    }

    public void setGruAprobarRequisiciones(Boolean gruAprobarRequisiciones) {
        this.gruAprobarRequisiciones = gruAprobarRequisiciones;
    }

    public Boolean getGruPlanificacion() {
        return gruPlanificacion;
    }

    public void setGruPlanificacion(Boolean gruPlanificacion) {
        this.gruPlanificacion = gruPlanificacion;
    }

    public Boolean getGruCamaronera() {
        return gruCamaronera;
    }

    public void setGruCamaronera(Boolean gruCamaronera) {
        this.gruCamaronera = gruCamaronera;
    }

    public Boolean getGruCalidad() {
        return gruCalidad;
    }

    public void setGruCalidad(Boolean gruCalidad) {
        this.gruCalidad = gruCalidad;
    }

    public Boolean getGruImprimirCodigoBarras() {
        return gruImprimirCodigoBarras;
    }

    public void setGruImprimirCodigoBarras(Boolean gruImprimirCodigoBarras) {
        this.gruImprimirCodigoBarras = gruImprimirCodigoBarras;
    }
}
