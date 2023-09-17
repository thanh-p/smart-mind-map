import { useEffect, useState } from "react";
import { retrieveDiagramNodeApi } from "./api/DiagramApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate, useParams, Link} from "react-router-dom";

function DiagramComponent() {

    const {diagramId, nodeId} = useParams()
    const [children, setChildren] = useState([])
    const [diagramInfo, setDiagramInfo] = useState([])

    useEffect (() => refreshDiagram(), [diagramId, nodeId])

    function refreshDiagram() {
        retrieveDiagramNodeApi(diagramId, nodeId)
        .then(response => { 
            setChildren(response.data.childNode)
            setDiagramInfo(response.data)
        })
        .catch(error => console.log(error))
    }

    return (
        <div className="container">
            <h1>{diagramInfo.title}</h1>
            <div className="d-flex flex-row">
                {children.map((child, index) => (
                    <Link
                        key={child.id}
                        className="p-2 text-decoration-none"
                        to={`/diagrams/${diagramId}/nodes/${child.id}`}
                    >
                        {child.title}
                    </Link>                  
                ))}
            </div>
      </div>
    )
}

export default DiagramComponent