package io.tads.dsd.rest.java.model;

import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class Resultado   {
  
  private Double valor = null;

  /**
   **/
  public Resultado valor(Double valor) {
    this.valor = valor;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public Double getValor() {
    return valor;
  }
  public void setValor(Double valor) {
    this.valor = valor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resultado resultado = (Resultado) o;
    return Objects.equals(valor, resultado.valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resultado {\n");
    
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
