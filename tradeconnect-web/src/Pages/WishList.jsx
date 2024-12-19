import styles from './styles/WishList.module.css'
import TopNavigationBar from '../Components/utils/TopNavigationBar'
import PageFooter from '../Components/utils/PageFooter';
import WishListBar from '../Components/Wishlist/wishListBar';
import RecomondationListBar from '../Components/Wishlist/RecomondationListBar';

function WishListPage() {
    return (
        <div className={styles.WishListPage}>
            <div className={styles.topNavigationBarContainer}>
                <TopNavigationBar />
            </div>
            <div className={styles.body}>
                <div className={styles.head}>
                    <p className={styles.wishListHeading}>Wish List</p>
                    <button className={styles.CartButton}>Move all to cart</button>
                </div>
                <div className={styles.allProducts}>
                    <WishListBar />
                </div>

                <div className={styles.recomondations}>
                    <p className={styles.recomondationsHeading}>Recomondations</p>
                </div>
                <div className={styles.allProducts}>
                    <RecomondationListBar />
                </div>
            </div>
            <div className={styles.footer}>
                <PageFooter />
            </div>
        </div>
    )
}

export default WishListPage;