/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabancario;

/**
 *
 * @author UVC
 */
public class ContaCorrente extends Conta {

    private double taxa;

    public ContaCorrente(int numeroConta, double saldoConta, String nomeConta, double taxa) {
        super(numeroConta, saldoConta, nomeConta);
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    @Override
    public String setSacar(double valorSaque) throws Exception {
        if (valorSaque <= 0) {
            throw new Exception("Valor de saque inválido");
        } else if (getSaldoConta() < valorSaque) {
            throw new Exception("Saldo insuficiente para saque");
        } else {
            setSaldoConta(getSaldoConta() - (valorSaque + taxa));
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
                + "Taxa por operação: " + getTaxa());
    }
}
