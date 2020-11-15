package com.picpay.desafio.android.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.applabbs.data.entity.User
import br.applabbs.infrastructure.base.BaseActivity
import br.applabbs.infrastructure.base.BaseViewModel
import br.applabbs.infrastructure.lifecycle.bindToVM
import com.bumptech.glide.Glide
import com.picpay.desafio.android.R
import com.picpay.desafio.android.view.adapter.UsersListAdapter
import com.picpay.desafio.android.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = viewModel
    private val viewModel: MainViewModel by viewModel()

    private lateinit var usersListAdapter: UsersListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
        setupRecycler()
        setupActions()
        viewModel.getUsers()
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.getUsers()
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
//        supportActionBar?.title = getString(R.string.main_repositories_toolbar_title, "?")
//        txt_total_repositories.text = getString(R.string.paginaAtual, position.toString())
    }

    private fun setupRecycler() {
        val decorator = DividerItemDecoration(recycler_view_repositories.context, DividerItemDecoration.VERTICAL)
        decorator.setDrawable(resources.getDrawable(R.drawable.divider_line))
        recycler_view_repositories.layoutManager = LinearLayoutManager(this)
        recycler_view_repositories.addItemDecoration(decorator)
    }

    private fun setupActions(){
        bindToVM(viewModel.error, ::showError)
        bindToVM(viewModel.loading, ::processLoading)
        bindToVM(viewModel.resposta, ::processRepos)
    }

    private fun showError(error: Boolean){
        if (error) {
            progress_bar.visibility = View.VISIBLE
            Toast.makeText(this, "Falha na requisição", Toast.LENGTH_SHORT).show()
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    private fun processLoading(loading: Boolean){
        if (loading) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    private fun processRepos(users : List<User>){

        usersListAdapter = UsersListAdapter(
            this, users, Glide.with(this)
        ){
            getOnClickItemDetails(it)
        }

        recycler_view_repositories.adapter = usersListAdapter
    }

    private fun getOnClickItemDetails(users: User){
        Toast.makeText(this, "Item clicked: ${users.name}", Toast.LENGTH_SHORT).show()
    }
}
