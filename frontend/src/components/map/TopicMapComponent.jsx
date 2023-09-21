import { useEffect, useState } from "react";
import { retrieveAllMapsFromTopicApi } from "./api/MapApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate, useParams, Link} from "react-router-dom";

function TopicMapComponent() {

    const {topicId} = useParams()
    const [mapList, setMapList] = useState([])

    useEffect (() => refreshMap(), [])

    function refreshMap() {
        retrieveAllMapsFromTopicApi(topicId)
        .then(response => { 
            setMapList(response.data)
        })
        .catch(error => console.log(error))
    }

    return (
        <div className="container">
            <h1>Maps</h1>
            <div className="d-flex flex-row">
                {mapList.map((child, index) => (
                    <Link
                        key={child.id}
                        className="p-2 text-decoration-none"
                        to={`/maps/${child.id}`}
                    >
                        {child.name}
                    </Link>
                ))}
            </div>
      </div>
    )
}

export default TopicMapComponent