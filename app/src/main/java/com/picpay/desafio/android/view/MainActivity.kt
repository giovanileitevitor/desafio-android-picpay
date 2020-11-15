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
        setupListeners()
        viewModel.getUsers()
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.getUsers()
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
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
            progress_bar.visibility = View.GONE
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    private fun processLoading(loading: Boolean){
        if (loading) {
            progress_bar.visibility = View.VISIBLE
            recycler_view_repositories.visibility = View.INVISIBLE
            txt_total_itens.text = " - "
        } else {
            progress_bar.visibility = View.GONE
            recycler_view_repositories.visibility = View.VISIBLE
        }
    }

    private fun processRepos(users : List<User>){
        txt_total_itens.text = getString(R.string.total_users, users.size.toString())

        usersListAdapter = UsersListAdapter(
            this, users, Glide.with(this)
        ){
            getOnClickItemDetails(it)
        }

        recycler_view_repositories.adapter = usersListAdapter
    }

    private fun getOnClickItemDetails(users: User){
        Toast.makeText(this, getString(R.string.txt_item_clicked, users.name), Toast.LENGTH_SHORT).show()
    }

    private fun setupListeners(){
        btn_next.setOnClickListener {
            Toast.makeText(this, getString(R.string.btn_paginacao), Toast.LENGTH_SHORT).show()
        }

        btn_previous.setOnClickListener {
            Toast.makeText(this, getString(R.string.btn_paginacao), Toast.LENGTH_SHORT).show()
        }
    }
}
