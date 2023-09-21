import { useEffect, useState } from "react";
import { retrieveMapApi } from "./api/MapApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate, useParams, Link} from "react-router-dom";

function MapComponent() {

    const {mapId} = useParams()
    const [mindmap, setMindmap] = useState([])
    const [nodes, setNodes] = useState([])

    useEffect (() => refreshMap(), [])

    function refreshMap() {
        retrieveMapApi(mapId)
        .then(response => {
            setMindmap(response.data)
            setNodes(response.data.nodes)
        })
        .catch(error => console.log(error))
    }

    const renderNodes = (inputNodes) => {
        return inputNodes.map((child, index) => (
            <div>
                <Link
                    key={child.id}
                    className="p-2 text-decoration-none"
                    to={`/nodes/${child.id}`}
                >
                    {child.name}
                </Link>
                {renderNodes(child.childNodes)}
            </div>
        ));
      };

    return (
        <div className="container">
            <h1>{mindmap.name}</h1>
            <div className="d-flex flex-row">
                {renderNodes(nodes)}
            </div>
      </div>
    )
}

export default MapComponent