import StatsBox from './StatsBox';
import styles from './styles/DetailsBar.module.css'
import customerIcon from '../../assets/images/About/customer.svg'
import saleIcon from '../../assets/images/About/sale.svg'
import sellerIcon from '../../assets/images/About/seller.svg'
import productIcon from '../../assets/images/About/product.svg'

function DetailsBar(){
    return(
        <div className={styles.DetailsBarContainer}>
            <div className={styles.box}>
                <StatsBox 
                icon={customerIcon}
                amount="45.5k"
                text="Customer active in our site"
                />
            </div>
            <div className={styles.box}>
            <StatsBox 
                icon={sellerIcon}
                amount="10.5k"
                text="Sallers active our site daily"
                />
            </div>
            <div className={styles.box}>
            <StatsBox 
                icon={productIcon}
                amount="33k"
                text="Monthly Produduct Sale"
                />
            </div>
            <div className={styles.box}>
            <StatsBox 
                icon={saleIcon}
                amount="25k"
                text="Anual gross sale in our site"
                />
            </div>
        </div>
    )
}

export default DetailsBar;