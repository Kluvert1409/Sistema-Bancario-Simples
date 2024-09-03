/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

/**
 *
 * @author UVC
 */
public abstract class Conta {

    private int numeroConta;
    private double saldoConta;
    private String nomeConta;

    public Conta(int numeroConta, double saldoConta, String nomeConta) {
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
        this.nomeConta = nomeConta;
    }

    public Conta(int numeroConta, String nomeConta) {
        this.numeroConta = numeroConta;
        this.nomeConta = nomeConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public abstract String setSacar(double valorSaque) throws Exception;

    public abstract String setDepositar(double valorDeposito) throws Exception;

    public abstract String getRetorno();
}
