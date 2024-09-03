/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

/**
 *
 * @author UVC
 */
public class ContaPoupanca extends Conta {

    private double rendimento;

    public ContaPoupanca(int numeroConta, double saldoConta, String nomeConta, double rendimento) {
        super(numeroConta, saldoConta, nomeConta);
        this.rendimento = rendimento;
    }

    public ContaPoupanca(int numeroConta, String nomeConta, double rendimento) {
        super(numeroConta, nomeConta);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void setRendimentoConta(double rendimento) {
        setSaldoConta(getSaldoConta() + (getSaldoConta() * rendimento));
    }

    public double getRendimentoConta() {
        return getSaldoConta() + (getSaldoConta() * rendimento);
    }

    @Override
    public String setSacar(double valorSaque) throws Exception {
        if (valorSaque <= 0) {
            throw new Exception("Valor de saque inválido");
        } else if (getSaldoConta() < valorSaque) {
            throw new Exception("Saldo insuficiente para saque");
        } else {
            setSaldoConta(getSaldoConta() - (valorSaque));
            return "Saque realizado com sucesso";
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
                + "Rendimento da conta: " + getRendimento());
    }
}
