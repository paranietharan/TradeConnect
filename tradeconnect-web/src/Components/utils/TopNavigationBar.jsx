import styles from './styles/TopNavigationBar.module.css';
import eCommerceLogo from '../../assets/e-commerce-logo.png';
import { Link } from 'react-router-dom';
import TopNavBarProfile from './TopNavBarProfile';


/**
 * TopNavigationBar Component
 * 
 * This component represents the top navigation bar used across the e-commerce website.
 * It includes the following elements:
 * - A logo that links to the homepage.
 * - Navigation links to different sections of the website (Home, Products, About, Login).
 * - A search bar for searching products.
 * - A profile icon that shows a dropdown menu when clicked, if the user is logged in.
 * 
 * The component uses CSS modules for styling.
 */
function TopNavigationBar() {
    return (
        <div className={styles.topNavigationBarContainer}>
            <div className={styles.logoContainer}>
                <img src={eCommerceLogo} alt='logo' />
            </div>

            <div className={styles.navLinksContainer}>
                <Link to='/'>Home</Link>
                <Link to='/'>Contact</Link>
                <Link to='/'>About</Link>
                <Link to='/'>Login</Link>
            </div>

            <div className={styles.searchBarContainer}>
                <input type='text' placeholder='Search for products...' />
                <button>
                    <i class="bi bi-search"></i>
                </button>
            </div>

            <div className={styles.cartFavContainer}>
                <Link to='/cart' className={styles.cart}>
                    <i class="bi bi-cart2"></i>
                </Link>
                <Link to='/favorites' className={styles.fav}>
                    <i class="bi bi-heart"></i>
                </Link>

                <div className={styles.profile}>
                    <TopNavBarProfile />
                </div>

            </div>
        </div>
    )
}

export default TopNavigationBar;