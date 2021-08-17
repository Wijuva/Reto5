package modelo.vo;

public class Requerimiento_2 {
    // Atributos
    private Integer ID_Proyecto;
    private String Proveedor;
    private String Pagado;
    private Integer ID_MaterialConstruccion;
    private String Nombre_Material;

    public Requerimiento_2(){
        
    }

    public Integer getID_Proyecto() {
        return ID_Proyecto;
    }
    public void setID_Proyecto(Integer iD_Proyecto) {
        ID_Proyecto = iD_Proyecto;
    }
    public String getProveedor() {
        return Proveedor;
    }
    public void setProveedor(String proveedor) {
        Proveedor = proveedor;
    }
    public String getPagado() {
        return Pagado;
    }
    public void setPagado(String pagado) {
        Pagado = pagado;
    }
    public Integer getID_MaterialConstruccion() {
        return ID_MaterialConstruccion;
    }
    public void setID_MaterialConstruccion(Integer iD_MaterialConstruccion) {
        ID_MaterialConstruccion = iD_MaterialConstruccion;
    }
    public String getNombre_Material() {
        return Nombre_Material;
    }
    public void setNombre_Material(String nombre_Material) {
        Nombre_Material = nombre_Material;
    }

}
