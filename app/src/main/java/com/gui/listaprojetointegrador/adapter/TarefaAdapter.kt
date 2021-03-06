package com.gui.listaprojetointegrador.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gui.listaprojetointegrador.R
import com.gui.listaprojetointegrador.Tarefa
import com.gui.listaprojetointegrador.model.TarefaViewModel

class tarefaAdapter(private val taskItemClickListener: ItemTarefaClick,
                    private val mainViewModel: TarefaViewModel)

    : RecyclerView.Adapter<tarefaAdapter.TarefaViewHolder>() {
    var listTarefas: MutableList<Tarefa> = mutableListOf()
    class TarefaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textNome = view.findViewById<TextView>(R.id.textNome)
        val textData = view.findViewById<TextView>(R.id.textData)
        val textHora = view.findViewById<TextView>(R.id.textHora)
        val textStatus = view.findViewById<TextView>(R.id.textStatus)
        val buttonAcessar = view.findViewById<Button>(R.id.buttonAcessar)

        fun binding(tarefa: Tarefa){
            textNome.text = tarefa.nome
            textData.text = tarefa.data
            textHora.text = tarefa.hora
            textStatus.text = tarefa.status

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val layoutAdapter = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_list, parent, false)

        return TarefaViewHolder(layoutAdapter)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.binding(listTarefas[position])
        val tarefa = listTarefas[position]
        holder.buttonAcessar.setOnClickListener{
            taskItemClickListener.clicarTarefa(tarefa)
        }

    }
    /*fun updateList(list: List<Tarefa>){
        this.listTarefas.clear()
        this.listTarefas.addAll(list)
        notifyDataSetChanged()
    }*/
    fun setData(tarefas: List<Tarefa>){
        this.listTarefas = tarefas as MutableList<Tarefa>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listTarefas.size
    }



}