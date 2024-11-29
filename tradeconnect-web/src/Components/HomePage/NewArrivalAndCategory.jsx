import styles from './styles/NewArrivalAndCategory.module.css';
import Category from '../Category';
import NewArrival from '../NewArrival';

/**
 * 
 * This is the component for the New Arrival and Category section of the homepage.
 */
function NewArrivalAndCategory(){
    return(
        <div className={styles.saleAndNewArrival}>
            {/* Category - left */}
            <Category />
            {/* New Arrival - right */}
            <NewArrival />
        </div>
    )
}

export default NewArrivalAndCategory;