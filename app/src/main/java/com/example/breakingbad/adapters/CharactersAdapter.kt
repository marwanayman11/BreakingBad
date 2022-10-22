package com.example.breakingbad.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.Character
import com.example.breakingbad.databinding.ItemBinding

class CharactersAdapter(private val onClickListener: OnClickListener)
    :ListAdapter<Character, CharactersAdapter.CharactersViewHolder>(DiffCallback) {
        class CharactersViewHolder(private var binding: ItemBinding):
                RecyclerView.ViewHolder(binding.root){
                    fun bind (character: Character){
                        binding.character = character
                        binding.executePendingBindings()
                    }
                }

    companion object DiffCallback: DiffUtil.ItemCallback<Character>(){
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }
    }
    class OnClickListener(val clickListener : (Character)-> Unit){
        fun onClick(character: Character) = clickListener(character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(character)
        }
        holder.bind(character)
    }
}