

document.addEventListener("DOMContentLoaded", ()=>{

    fetch("/api/user/full/1")
        .then(response => response.json())
        .then(user =>{
            document.getElementById("nome").textContent = user.nomeCliente
        }).catch(err => console.error("Erro", err))
})


const tabs = document.querySelectorAll(".tab");
const pages = document.querySelectorAll(".page");

tabs.forEach((tab) => {
    tab.addEventListener("click", () => {
        const alvo = tab.dataset.tab;

        tabs.forEach((t) => t.classList.remove("tab--active"));
        pages.forEach((p) => p.classList.remove("page--active"));

        tab.classList.add("tab--active");
        document.getElementById(alvo).classList.add("page--active");
    });
});

// --- Simulador de energia solar (JS simples) ---
const btnSimular = document.getElementById("btn-simular");

btnSimular.addEventListener("click", () => {
    const gasto = Number(document.getElementById("gasto").value) || 0;
    const entrada = Number(document.getElementById("entrada").value) || 0;
    const prazo = Number(document.getElementById("prazo").value) || 0;

    if (!gasto || !prazo) {
        alert("Preencha pelo menos o gasto médio e o prazo 😊");
        return;
    }

    // Regras bem simples só pra exemplo:
    // - valor do sistema ≈ 60 x gasto
    // - parcela ≈ (valor - entrada) / prazo
    // - economia mensal ≈ 0.7 x gasto
    const valorSistema = gasto * 60;
    const restante = Math.max(valorSistema - entrada, 0);
    const parcela = prazo > 0 ? restante / prazo : 0;
    const economia = gasto * 0.7;
    const retornoMeses = economia > 0 ? restante / economia : 0;
    const retornoAnos = retornoMeses / 12;

    document.getElementById("parcela").textContent =
        "R$ " + parcela.toFixed(2).replace(".", ",");
    document.getElementById("economia").textContent =
        "R$ " + economia.toFixed(2).replace(".", ",");
    document.getElementById("retorno").textContent =
        retornoAnos.toFixed(1).replace(".", ",") + " anos";
})