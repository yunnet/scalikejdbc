package scalikejdbc

import java.sql.Connection

/**
 * Represents that already existing session will be used or a new session will be started.
 */
case object AutoSession extends DBSession {
  override private[scalikejdbc] val conn: Connection = null
  val tx: Option[Tx] = None
  val isReadOnly: Boolean = false

  override def fetchSize(fetchSize: Int): DBSession = unexpectedInvocation
  override def fetchSize(fetchSize: Option[Int]): DBSession = unexpectedInvocation
  override def tags(tags: String*): DBSession = unexpectedInvocation
  override private[scalikejdbc] lazy val connectionAttributes: DBConnectionAttributes = unexpectedInvocation
}

/**
 * Represents that already existing session will be used or a new session
 * which is retrieved from named connection pool will be started.
 */
case class NamedAutoSession(name: Any) extends DBSession {
  override private[scalikejdbc] val conn: Connection = null
  val tx: Option[Tx] = None
  val isReadOnly: Boolean = false

  override def fetchSize(fetchSize: Int): DBSession = unexpectedInvocation
  override def fetchSize(fetchSize: Option[Int]): DBSession = unexpectedInvocation
  override def tags(tags: String*): DBSession = unexpectedInvocation
  override private[scalikejdbc] lazy val connectionAttributes: DBConnectionAttributes = unexpectedInvocation
}
