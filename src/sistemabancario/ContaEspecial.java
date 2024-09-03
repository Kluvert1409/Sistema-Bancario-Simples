/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

/**
 *
 * @author UVC
 */
public class ContaEspecial extends Conta {

    private double limite;

    public ContaEspecial(int numeroConta, double saldoConta, String nomeConta, double limite) {
        super(numeroConta, saldoConta, nomeConta);
        this.limite = limite;
    }

    public ContaEspecial(int numeroConta, String nomeConta, double limite) {
        super(numeroConta, nomeConta);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String setSacar(double valorSaque) throws Exception {
        if (valorSaque <= 0) {
            throw new Exception("Valor de saque inválido");
        } else if (valorSaque > getSaldoConta() + getLimite()) {
            throw new Exception("Saldo insuficiente para saque");
        } else {
            setSaldoConta(getSaldoConta() - valorSaque);
            return ("Saque realizado com sucesso");
        }
    }

    @Override
    public String setDepositar(double valorDeposito) throws Exception {
        if (valorDeposito <= 0) {
            throw new Exception("Valor de depósito inválido");
        } else {
            setSaldoConta(getSaldoConta() + valorDeposito);
            return "Depósito realizado com sucesso";
        }
    }

    @Override
    public String getRetorno() {
        return ("Nome do cliente: " + getNomeConta() + "\n"
                + "Número da conta: " + getNumeroConta() + "\n"
                + "Saldo: " + getSaldoConta() + "\n"
                + "Limite adicional: " + getLimite());
    }
}
