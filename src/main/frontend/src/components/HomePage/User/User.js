import "./User.css";
import {Link} from "react-router-dom"


const User = (props) => {
    return (
        <>
            {props.user.map((user, key) => (
                <div className="user" key={key}>
                    <div className="photo">{user.name[0]}</div>
                    <div className="name">{user.name}</div>
                    <div className="username">{user.username}</div>
                    <div className="email">{user.email}</div>
                    <Link to={`/users/${user.id}`}>
                        <button className="btn">
                            MORE DETAIL
                        </button>
                    </Link>
                </div>)
            )
            }
        </>
    );
}

export default User;
