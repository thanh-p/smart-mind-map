import { useEffect, useState } from "react";
import { retrieveTopicApi } from "./api/MapApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate, useParams, Link} from "react-router-dom";

function TopicComponent() {

    const [topicList, setTopicList] = useState([])

    useEffect (() => refreshTopic(), [])

    function refreshTopic() {
        retrieveTopicApi()
        .then(response => { 
            setTopicList(response.data)
        })
        .catch(error => console.log(error))
    }

    return (
        <div className="container">
            <h1>Topics</h1>
            <div className="d-flex flex-row">
                {topicList.map((child, index) => (
                    <Link
                        key={child.id}
                        className="p-2 text-decoration-none"
                        to={`/topics/${child.id}/maps`}
                    >
                        {child.name}
                    </Link>
                ))}
            </div>
      </div>
    )
}

export default TopicComponent