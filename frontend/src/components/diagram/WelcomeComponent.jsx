import {useParams, Link} from 'react-router-dom'
import { useState } from 'react'

function WelcomeComponent() {

    const {username} = useParams()

    return (
        <div className="welcome">
            <h1>Welcome {username}</h1>
            <div>
                See a sample - <Link to="/diagrams/1/nodes/0">Go here</Link>
            </div>
        </div>
    )
}

export default WelcomeComponent