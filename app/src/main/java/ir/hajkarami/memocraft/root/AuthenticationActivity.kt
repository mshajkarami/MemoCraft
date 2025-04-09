package ir.hajkarami.memocraft.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.hajkarami.memocraft.R
import ir.hajkarami.memocraft.fragment.RegisterFragment
import ir.hajkarami.memocraft.fragment.WelcomeFragment
import ir.hajkarami.memocraft.model.AuthenticationModel
import ir.hajkarami.memocraft.presenter.AuthenticationPresenter
import ir.hajkarami.memocraft.view.AuthenticationView

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = AuthenticationView(this)
        setContentView(view.binding.root)
        val model = AuthenticationModel()
        val presenter = AuthenticationPresenter(view,model)
        presenter.onCreatePresenter()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, WelcomeFragment())
                .commit()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (currentFragment is WelcomeFragment) {
            finish()
        } else if (currentFragment is RegisterFragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, WelcomeFragment())
                .addToBackStack(null)
                .commit()
        } else {
            super.onBackPressed()
        }
    }

}
